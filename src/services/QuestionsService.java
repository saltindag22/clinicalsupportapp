public class QuestionsService {
    @Autowired
    private QuestionRepository repo;

    public Questions getById(String id) {
        return repo.findById(id).orElse(null);
    }

    public List<Questions> getAllQuestions() {
        return repo.findAll();
    }
    public Questions createQuestion(String title, String content, String author) {
        Questions question = new Questions();
        question.setTitle(title);
        question.setContent(content);
        question.setAuthor(author);
        question.setCreationDate(LocalDateTime.now());
        return repo.save(question);
    }
    public void deleteQuestion(String id){
        ArrayList<Questions> questions = repo.getAllQuestions();
        Questions ques = repo.findById(id);
        try{
            questions.remove(ques);
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    public Question updateQuestion(String id, String title, String content){
            Questions question = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Question not found"));
        question.setTitle(title);
        question.setContent(content);
        return repo.save(question);
        }

    }