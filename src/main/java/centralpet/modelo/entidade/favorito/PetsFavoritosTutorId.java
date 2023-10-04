package centralpet.modelo.entidade.favorito;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

	@Embeddable
	public class PetsFavoritosTutorId implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long tutorId;
		
		private Long petId;
		
		public PetsFavoritosTutorId() {}
		
		public PetsFavoritosTutorId(Long tutorId, Long petId) {
			super();
			setTutorId(tutorId);
			setPetId(petId);
		}

		public Long getTutorId() {
			return tutorId;
		}

		public void setTutorId(Long tutorId) {
			this.tutorId = tutorId;
		}

		public Long getPetId() {
			return petId;
		}

		public void setPetId(Long petId) {
			this.petId = petId;
		}
		
		@Override
	    public int hashCode() {
	        final int prime = 31;
	        int result = 1;
	        result = prime * result
	                + ((tutorId == null) ? 0 : tutorId.hashCode());
	        result = prime * result
	                + ((petId == null) ? 0 : petId.hashCode());
	        return result;
	    }
	 
	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj)
	            return true;
	        if (obj == null)
	            return false;
	        if (getClass() != obj.getClass())
	            return false;
	        PetsFavoritosTutorId other = (PetsFavoritosTutorId) obj;
	        return Objects.equals(getTutorId(), other.getTutorId()) && Objects.equals(getPetId(), other.getPetId());
	    }
}
	
