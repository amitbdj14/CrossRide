# CrossRide


bugs found

Email field was corrected in person.java class ---having issue email validations
 @javax.validation.constraints.NotNull
  @Column(name = "email")
  String email;

corrected was not working
@GetMapping(path = "/api/person/{person-id}")
  public ResponseEntity<Person> getPersonById(@PathVariable(name="person-id", required=true)Long personId) {
    Person person = personService.findById(personId);
    if (person != null) {
      return ResponseEntity.ok(person);
    }
    return ResponseEntity.notFound().build();
  }
	
	
	added for RideController
	@GetMapping(path ="/api/ride")
  public ResponseEntity<Iterable<Ride>> getNewRide() {
    return ResponseEntity.ok(rideService.getAll());
  }
	@Override
public Iterable<Ride> getAll() {
	return rideRepository.findAll();
}

public Iterable<Ride> getAll();
