package org.springframework.samples.petclinic.recoveryroom;

import javax.naming.spi.DirStateFactory.Result;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
    @Autowired
    RecoveryRoomService recoveryRoomService;

    @GetMapping(path = "recoveryroom/create")
    public String getRRCreate(ModelMap modelMap) {
        modelMap.addAttribute("recoveryRoom", new RecoveryRoom());
        return "recoveryroom/createOrUpdateRecoveryRoomForm";
    }

    @PostMapping(path = "recoveryroom/create")
    public String postRRCreate(ModelMap modelMap, @Valid RecoveryRoom recoveryRoom  ,BindingResult result){
        if(result.hasErrors()){
            modelMap.addAttribute("recoveryRoom", recoveryRoom);
            return "recoveryroom/createOrUpdateRecoveryRoomForm";
        } 
        recoveryRoomService.save(recoveryRoom);
        return "welcome";
    }
}
