package co.edu.unbosque.backSucursal3.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.backSucursal3.models.Detalle_venta;
import co.edu.unbosque.backSucursal3.repositories.Detalle_ventaDAO;

@RestController
@CrossOrigin(origins ="*",methods = { RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
		RequestMethod.DELETE})
@RequestMapping("/api/detalle_venta")
public class Detalle_ventaAPI {
	
	@Autowired
	private Detalle_ventaDAO detalleventadao;
	
	@PostMapping("/guardar")
	public  Detalle_venta guardar(@Validated @RequestBody Detalle_venta detalleventa) {
		return detalleventadao.insert(detalleventa);
	}
	
	@GetMapping("/listar")
	public List<Detalle_venta> listar(){
		return detalleventadao.findAll();
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Detalle_venta detalleventa) {
		detalleventadao.save(detalleventa);
		
	}
	
	@DeleteMapping("/eliminar/{id}")
	public void eliminar(@PathVariable String id) {
		detalleventadao.deleteById(id);
	}
}
