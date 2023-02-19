package src.main.java.com.healthplus.dataaccess.controller;

@Controller
@RequestMapping(path="/schemes")
public class SchemeController {
@Autowired
	@GetMapping(path = "/")
	public List<Scheme> listScheme() {
	    return schemeRepository.findAll();
	}
@GetMapping(path="/{id}")
public Optional<Scheme> getschemeBy(@PathVariable("id") Long id){
	return schemeRepository.findById(id);
}
}
