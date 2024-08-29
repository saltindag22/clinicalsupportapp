import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@Controller
@RequestMapping("/question")
public class QuestionsController {

    private QuestionsService quesService;

    @Autowired
    public QuestionsController(QuestionsService quesService) {
        this.quesService = quesService;
    }

    @PostMapping("/question")
    public Questions createQuestion(@RequestBody Questions quesBody) {
        Questions newQuestion = quesService.createQuestion(
            quesBody.getTitle(),
            quesBody.getContent(),
            quesBody.getAuthor()
    );
    return newQuestion;
}

    @GetMapping("/displayall")
    public List<Questions> getAllQuestions(){
        return quesService.getAllQuestions();
    }

    @PutMapping("/update")
    public Questions updateQuestion(@RequestBody Questions quesBody){
        Questions upQuestion = quesService.updateQuestion(quesBody.getId(), quesBody.getTitle(), quesBody.getContent());
        return upQuestion;
    } 
    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(String id){
        quesService.deleteQuestion(id);
    }


}
