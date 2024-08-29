
@Controller
@RequestMapping("/doctor")
public class DoctorsController {
    private  DoctorsService drService;

    @Autowired
    public DoctorsController(DoctorsService drService) {
        this.drService = drService;
    }
    @GetMapping("/displayall")
    public List<Doctors> getAllDoctors(){
        return drService.getAllDoctors();
    }

    @PostMapping("/register")
    public Doctors register(@RequestBody Doctors doctorBody) {
        Doctors newDoctor = drService.register(doctorBody.getId(),doctorBody.getUsername(), doctorBody.getPassword());
        return newDoctor;
    }
    @PostMapping("/login")
    public Doctors login(@RequestBody Doctors doctorBody) {
        try {
            Doctors doctor = drService.login(doctorBody.getId(),doctorBody.getUsername(), doctorBody.getPassword());
            return doctor;
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
    @PutMapping("/update")
    public Doctors updateDr(@RequestBody Doctors doctorBody){
        Doctors upDr = drService.updateDr(doctorBody.getId(),doctorBody.getName(), doctorBody.getPassword(), doctorBody.getProfession(), doctorBody.getWorkplace(), doctorBody.getGradSchool());
        return upDr;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteQuestion(String id){
        drService.deleteDr(id);
    }
}


