import org.springframework.beans.factory.annotation.Autowired;

public class DoctorsService {
    @Autowired
    private DoctorRepository repo;


    public Doctors getById(String id) {
        return repo.findById(id).orElse(null);
    }
    public List<Doctors> getAllDoctors(){
        return repo.findAll();
    }

    public void register(String id, String name, String password) {
        Doctors user = repo.findByUsername(id);
        if (user.isPresent()) {
            throw new IllegalArgumentException("Username already exists");
        } else {
            Doctor newDoctor = new Doctor();
            newDoctor.setId();
            newDoctor.setName(name);
            newDoctor.setPassword(password);
            return repo.save(newDoctor);
        }
    }

    public Doctors login (String id, String name, String password){
        Doctors user = repo.findByUsername(id);
        if (user.isPresent()) {
            Doctors doctor = user.get();
            if (doctor.getPassword().equals(password)) {
                return doctor;
            } else {
                throw new IllegalArgumentException("Invalid password");
            }
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }

    public void deleteDr(String id){
        ArrayList<Doctors> doctors = repo.getAllDoctors();
        Doctors doctor = repo.findById(id);
        try{
            doctors.remove(doctor);
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }
    public Question updateDr(String id, String name,  String password, String profession, String workplace, String gradSchool) {
            Doctors doctor = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Doctor not found"));
        doctor.setName(name);
        doctor.setPassword(password);
        doctor.setProfession(profession);
        doctor.setWorkplace(workplace);
        doctor.setGradSchool(gradSchool);
        return repo.save(doctor);
        }

}

