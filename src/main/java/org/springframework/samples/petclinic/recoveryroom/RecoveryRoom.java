package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.ManyToAny;
import org.springframework.samples.petclinic.model.NamedEntity;

import lombok.Getter;
import lombok.Setter;

@Table(name = "recovery_rooms")
@Entity
@Getter
@Setter
public class RecoveryRoom extends NamedEntity{

    @NotNull
    @Min(0)
    double size;

    @NotNull
    boolean secure;

    @ManyToOne(optional = false)
    @NotNull
    @JoinColumn(name="recovery_room_type_id")
    RecoveryRoomType roomType;
}
