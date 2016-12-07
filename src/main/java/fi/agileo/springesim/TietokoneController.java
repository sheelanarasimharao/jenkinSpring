package fi.agileo.springesim;

import java.util.List;

import javax.inject.Inject;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/* Kutsutaan suhteessa alkupolkuun, esim. 
  /tietokoneet/koneet/listaa
  /tietokoneet/kone/uusi
  /tietokoneet/kone/nimi
*/
@Controller
@RequestMapping(value = "/")
public class TietokoneController {

	// Injektoidaan standardi JPA:ta käyttävä TietokoneDAO komponentti

	@Inject
	// @Autowired
	private TietokoneDAO tkp;

	// Lomakkeen luominen

	@RequestMapping(value = "/lomake", method = RequestMethod.GET)
	public String newForm(Model model) {
		Tietokone tk = new Tietokone();
		model.addAttribute("tietokone", tk);
		return "lomake";
	}

	// Lomakkeen tietojen ottaminen vastaan

	@RequestMapping(value = "/lomake", method = RequestMethod.POST)
	public String addNew(@Valid Tietokone tk, ModelMap model) {

		// vakiokone talteen
		Tietokone tk2 = new Tietokone();
		tk2.setMerkki("Apple");
		tk2.setMalli("MacBook");
		tkp.save(tk2);

		// tallennetaan lomakkeelta luettu kone
		Tietokone tkone = tkp.save(tk);
		model.addAttribute("tietokone", tkone);
		return "uusi";
	}

	// Kaikki tietokoneet listattuna
	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model) {
		List<Tietokone> tkoneet = tkp.findAll();

		model.addAttribute("tietokoneet", tkoneet);
		return "listaa";
	}

}
