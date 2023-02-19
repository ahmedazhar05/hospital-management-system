package src.main.java.com.healthplus.dataaccess.controller;

@Controller
@RequestMapping(path = "/reports")
public class ReportController {
	@Autowired
	private ReportRepository reportRepository;
	@GetMapping(path = "/search", params = "patient")
	public List<Report> getReportsBy(@RequestParam("patient") Long id) {
	return reportRepository.getReportsByPtient(id);
}
	@GetMapping(path = "/{id}")
	public Optional<Report> getReportBy(@PathVariable("id") Long id) {
	return reportRepository.findById(id);
	}
	