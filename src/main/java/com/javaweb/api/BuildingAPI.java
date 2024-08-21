package com.javaweb.api;

import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.Beans.BuildingDTO;

@RestController
public class BuildingAPI {

//	@RequestMapping(value = "/api/building/", method = RequestMethod.GET) // old
	@GetMapping("/api/building/") // new
	// send Param and result Param
	public BuildingDTO getBuilding(@RequestParam(value = "name", required = false) String nameBuilding,
			@RequestParam(value = "age", required = false) Integer ageBuilding) {
		BuildingDTO result = new BuildingDTO();
		result.setName(nameBuilding);
		result.setAge(ageBuilding);
		System.out.print(nameBuilding + " and " + ageBuilding);
		return result;
	}

//	// send Param, use Map<>
//	@PostMapping("/api/building/")
//	public void getBuilding1(@RequestParam Map<String, String> params) {
//		System.out.print("getBuilding1");
//	}

	// send Body, use Java Bean
	@PostMapping("/api/building/")
	public BuildingDTO getBuilding2(@RequestBody BuildingDTO buildingdto) {
		// sau khi xu ly duoi DB
		System.out.print(buildingdto);
		return buildingdto;
	}

	//
	@DeleteMapping("/api/building/{id}/{name}/")
	public void delBuilding(@PathVariable Integer id,
			@PathVariable String name
			) {
		System.out.print("Da xoa id = "+id+" va name = "+name);
	}
}
