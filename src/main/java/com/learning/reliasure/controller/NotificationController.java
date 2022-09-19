package com.learning.reliasure.controller;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.reliasure.model.Notification;

@Controller
@RequestMapping("/notification")
public class NotificationController {

	// add a initbinder ... to convert trim input strings
	// remove leading and triling whitespace
	// resolve issue for our validation

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {

		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@RequestMapping("/showForm")
	public String showForm(Model theModel) {

		// create a notification object
		Notification notification = new Notification();

		// add notification object to the model
		theModel.addAttribute("notification", notification);

		return "notification-form";
	}

	@RequestMapping("/processForm")
	public String processForm(@Valid @ModelAttribute("notification") Notification notification,
			BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {
			return "notification-form";

		} else {
			
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(Notification.class).buildSessionFactory();
			
			Session session = factory.getCurrentSession();
			
			try {
				
				session.beginTransaction();
				session.save(notification);
				session.getTransaction().commit();
				System.out.println("Done!");
				
			}finally {
				factory.close();
			}

			return "notification-confirmation";
		}
	}

}
