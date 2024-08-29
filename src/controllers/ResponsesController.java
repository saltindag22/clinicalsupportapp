
@Controller
@RequestMapping("/response")
public class ResponsesController {
    private ResponsesService responseService;

    @Autowired
    public CommentController(ResponsesService responseService) {
        this.responseService = responseService;
    }

    @PostMapping("/respond")
    public Responses createResponse(@PathVariable Long questionId, @RequestBody CommentRequest commentRequest) {
        Comment comment = commentService.createComment(
                questionId,
                commentRequest.getContent(),
                commentRequest.getAuthor()
        );
        return comment;
    }

    @GetMapping("/dsplyrspnbyques")
    public ResponseEntity<List<Responses>> getResponsesByQuestionId(@PathVariable Long questionId) {
        List<Responses> responses = responseService.getResponsesByQuestionId(questionId);
        return ResponseEntity.ok(responses);
    }
}


