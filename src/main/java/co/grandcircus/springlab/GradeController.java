package co.grandcircus.springlab;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradeController {

	@Autowired
	private GradeDao gradeDao;
	
	@RequestMapping("/")
	public String index() {
		return "redirect:/grades";
	}
	
	@RequestMapping("/grades")
	public String list(Model model) {
		List<Grade> grades = gradeDao.findAll();
		model.addAttribute("grades", grades);
		BigDecimal totalScore = new BigDecimal(0);
		BigDecimal sumTotal = new BigDecimal(0);
		for (Grade grade : grades) {
			totalScore = totalScore.add(grade.getScore());
			sumTotal = sumTotal.add(grade.getTotal());
		}
		BigDecimal totalGrade = totalScore.divide(sumTotal, 1, RoundingMode.HALF_UP).multiply(new BigDecimal(100));
		model.addAttribute("totalGrade", totalGrade);
		return "list";
	}
	
	@RequestMapping("/grades/add")
	public String showAddForm() {
		return "add";
	}
	
	@RequestMapping("/grades/addconfirmation")
	public String reviewConfirmation(Grade grade,
			Model model) {
		gradeDao.create(grade);
		model.addAttribute("grade", grade);
		return "addconfirmation";
	}
	
	@RequestMapping("/grades/detail")
	public String gradeDetail(@RequestParam Long id, Model model) {
		Grade grade = gradeDao.findById(id);
		model.addAttribute("grade", grade);
		return "detail";
	}
	
	@RequestMapping("/grades/delete")
	public String showDeletePage(@RequestParam Long id) {
		gradeDao.delete(id);
		return "redirect:/grades";
	}
	
	@RequestMapping("/grades/deleteconfirmation")
	public String deletePage(@RequestParam Long id, Model model) {
		Grade grade = gradeDao.findById(id);
		model.addAttribute("grade", grade);
		return "deleteconfirmation";
	}
}
