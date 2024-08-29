import org.springframework.beans.factory.annotation.Autowired;

public class ResponsesService {

    @Autowired
    private ResponsesRepository resRepo;
    @Autowired
    private QuestionsRepository quesRepo;

    public Responses createResponse(Long questionId, String content, String author) {
        Questions question = questionService.getQuestionById(questionId);
        Responses response = new Responses();
        response.setContent(content);
        response.setAuthor(author);
        response.setCreatedAt(LocalDateTime.now());
        response.setQuestion(question);
        return resRepo.save(comment);
    }

    public List<Responses> getResponsesByQuestionId(Long questionId) {
        return resRepo.findByQuestionId(questionId);
    }

    

}
