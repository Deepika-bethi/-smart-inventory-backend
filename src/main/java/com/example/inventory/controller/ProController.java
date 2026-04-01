// // package com.example.inventory.controller;

// // import com.example.inventory.entity.Pro;
// // import com.example.inventory.repository.ProRepository;
// // import org.springframework.web.bind.annotation.CrossOrigin;
// // import org.springframework.web.bind.annotation.GetMapping;
// // import org.springframework.web.bind.annotation.PostMapping;
// // import org.springframework.web.bind.annotation.RequestBody;
// // import org.springframework.web.bind.annotation.RequestMapping;
// // import org.springframework.web.bind.annotation.RestController;

// // import java.util.List;

// // @CrossOrigin(origins = "https://smart-inventory-frontend-lime.vercel.app")
// // @RestController
// // @RequestMapping("/api/pro")
// // public class ProController {

// //     private final ProRepository proRepository;

// //     public ProController(ProRepository proRepository) {
// //         this.proRepository = proRepository;
// //     }

// //     @GetMapping
// //     public List<Pro> getAllPro() {
// //         return proRepository.findAll();
// //     }

// //     @PostMapping
// //     public Pro savePro(@RequestBody Pro pro) {
// //         return proRepository.save(pro);
// //     }

// //     // Add @GetMapping("/{id}"), @PutMapping, @DeleteMapping as needed
// // }




// package com.example.inventory.controller;

// import com.example.inventory.entity.Pro;
// import com.example.inventory.repository.ProRepository;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import java.util.List;

// @CrossOrigin(origins = "https://smart-inventory-frontend-lime.vercel.app")
// @RestController
// @RequestMapping("/api/pro")
// public class ProController {

//     private final ProRepository proRepository;

//     public ProController(ProRepository proRepository) {
//         this.proRepository = proRepository;
//     }

//     @GetMapping
//     public List<Pro> getAllPro() {
//         return proRepository.findAll();
//     }

//     /**
//      * @param pro
//      * @return
//      */
//     @PostMapping
//     public Pro savePro(@RequestBody Pro pro) {
//         return proRepository.save(pro);
//     }

//     // Add @GetMapping("/{id}"), @PutMapping, @DeleteMapping as needed
// }
// ```



package com.example.inventory.controller;

import com.example.inventory.entity.Pro;
import com.example.inventory.repository.ProRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "https://smart-inventory-frontend-lime.vercel.app")
@RestController
@RequestMapping("/api/pro")
public class ProController {

    private final ProRepository proRepository;

    public ProController(ProRepository proRepository) {
        this.proRepository = proRepository;
    }

    @GetMapping
    public List<Pro> getAllPro() {
        return proRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pro> getProById(@PathVariable Long id) {
        return proRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Pro> savePro(@RequestBody Pro pro) {
        Pro saved = proRepository.save(pro);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pro> updatePro(@PathVariable Long id, @RequestBody Pro pro) {
        return proRepository.findById(id)
                .map(existing -> {
                    existing.setName(pro.getName());
                    existing.setDescription(pro.getDescription());
                    // set other fields from pro to existing as needed
                    Pro updated = proRepository.save(existing);
                    return ResponseEntity.ok(updated);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePro(@PathVariable Long id) {
        return proRepository.findById(id)
                .map(existing -> {
                    proRepository.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}


