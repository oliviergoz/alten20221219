package exoFormation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exoFormation.repository.FormateurRepository;
import exoFormation.repository.FormationRepository;

@Service
public class FormateurService {

	@Autowired
	private FormateurRepository formateurRepo;
	@Autowired
	private FormationRepository formationRepo;
}
