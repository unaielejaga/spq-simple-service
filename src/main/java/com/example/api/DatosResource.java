package com.example.api;


import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;

import org.json.JSONObject;

import com.example.config.Secured;
import com.example.jdo.Distribuidor;
import com.example.jdo.Producto;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.SecurityContext;

@Path("data")
public class DatosResource {
	
	
	public List<Distribuidor> getDistrisDB(String username){
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
		Query<Distribuidor> q = pm.newQuery("SELECT FROM " + Distribuidor.class.getName() + " WHERE nombre== '" + username + "'");
		List<Distribuidor> distris = q.executeList();
		pm.close();
		return distris;
	}
	
	@GET
	@Path("all")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getAllData(@Context SecurityContext securityContext) {
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
		}
		
		return array_productos;	
    }
	
	@GET
	@Path("nombre")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getNombreData(@QueryParam("nombre") String nombre, @Context SecurityContext securityContext) {
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		ArrayList<Producto> array_nombre = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			for(Producto prod : array_productos) {
				if(prod.getNombre().equals(nombre)) array_nombre.add(prod);
			}
		}
		
		return array_nombre;	
    }
	
	@GET
	@Path("marca")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getMarcaData(@QueryParam("marca") String marca, @Context SecurityContext securityContext) {
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		ArrayList<Producto> array_marca = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			for(Producto prod : array_productos) {
				if(prod.getMarca().equals(marca)) array_marca.add(prod);
			}
		}
		
		return array_marca;	
    }
	
	@GET
	@Path("fechacad")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getFechaCadData(@QueryParam("fechacad") String fechacad, @Context SecurityContext securityContext) {
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		ArrayList<Producto> array_fecha = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			for(Producto prod : array_productos) {
				if(prod.getFechacad().equals(fechacad)) array_fecha.add(prod);
			}
		}
		
		return array_fecha;	
    }
	
	@GET
	@Path("fechacomp")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getFechaCompData(@QueryParam("fechacomp") String fechacomp, @Context SecurityContext securityContext) {
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		ArrayList<Producto> array_fecha = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			for(Producto prod : array_productos) {
				if(prod.getFechacompr().equals(fechacomp)) array_fecha.add(prod);
			}
		}
		
		return array_fecha;	
    }
	
	@GET
	@Path("fechacons")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getFechaConsData(@QueryParam("fechacons") String fechacons, @Context SecurityContext securityContext) {
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		ArrayList<Producto> array_fecha = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			for(Producto prod : array_productos) {
				if(prod.getFechacons().equals(fechacons)) array_fecha.add(prod);
			}
		}
		
		return array_fecha;	
    }
	
	@GET
	@Path("rangfechacons")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getRangFechaConsData(@QueryParam("fechacons1") String fechacons1, @QueryParam("fechacons2") String fechacons2, @Context SecurityContext securityContext) throws ParseException {
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		ArrayList<Producto> array_fecha = new ArrayList<>();
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fechacons1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(fechacons2);
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			for(Producto prod : array_productos) {
				Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacons());
				if(dateProd.after(date1) && dateProd.before(date2)) array_fecha.add(prod);
			}
		}
		
		return array_fecha;	
    }
	
	@GET
	@Path("rangfechacomp")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Producto> getRangFechaCompData(@QueryParam("fechacomp1") String fechacomp1, @QueryParam("fechacomp2") String fechacomp2, @Context SecurityContext securityContext) throws ParseException {
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		ArrayList<Producto> array_fecha = new ArrayList<>();
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(fechacomp1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(fechacomp2);
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			for(Producto prod : array_productos) {
				Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
				if(dateProd.after(date1) && dateProd.before(date2)) array_fecha.add(prod);
			}
		}
		
		return array_fecha;	
    }
	
	@GET
	@Path("prodmesvendnombre")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public int getProdMesVendNombreData(@QueryParam("mes") String mes, @QueryParam("nombre") String nombre, @Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		Date d = new Date();
		String anyo = String.valueOf(d.getYear()+1900);
		String strdate1 = "31/" + String.valueOf(Integer.parseInt(mes) - 1) + "/" + anyo;
		String strdate2 = "01/" + String.valueOf(Integer.parseInt(mes) + 1) + "/" + anyo;
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
		int numProd = 0;
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			for(Producto prod : array_productos) {
				Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
				if(dateProd.after(date1) && dateProd.before(date2)) {
					if(prod.getNombre().equals(nombre)) {
						numProd++;
					}
				}
			}
		}
		return numProd;	
    }
	
	@GET
	@Path("prodmesvendmarca")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public int getProdMesVendMarcaData(@QueryParam("mes") String mes, @QueryParam("marca") String marca, @Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		Date d = new Date();
		String anyo = String.valueOf(d.getYear()+1900);
		String strdate1 = "31/" + String.valueOf(Integer.parseInt(mes) - 1) + "/" + anyo;
		String strdate2 = "01/" + String.valueOf(Integer.parseInt(mes) + 1) + "/" + anyo;
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
		int numProd = 0;
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			for(Producto prod : array_productos) {
				Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
				if(dateProd.after(date1) && dateProd.before(date2)) {
					if(prod.getMarca().equals(marca)) {
						numProd++;
					}
				}
			}
		}
		return numProd;	
    }
	
	@GET
	@Path("prodanyovendnombre")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public int getProdAnyoVendNombreData(@QueryParam("anyo") String anyo, @QueryParam("nombre") String nombre, @Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		String strdate1 = "31/12/" + String.valueOf(Integer.parseInt(anyo) - 1);
		String strdate2 = "01/01/" + String.valueOf(Integer.parseInt(anyo) + 1);
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
		int numProd = 0;
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			for(Producto prod : array_productos) {
				Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
				if(dateProd.after(date1) && dateProd.before(date2)) {
					if(prod.getNombre().equals(nombre)) {
						numProd++;
					}
				}
			}
		}
		return numProd;	
    }
	
	@GET
	@Path("prodanyovendmarca")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public int getProdAnyoVendMarcaData(@QueryParam("anyo") String anyo, @QueryParam("marca") String marca, @Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		String strdate1 = "31/12/" + String.valueOf(Integer.parseInt(anyo) - 1);
		String strdate2 = "01/01/" + String.valueOf(Integer.parseInt(anyo) + 1);
		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
		int numProd = 0;
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			for(Producto prod : array_productos) {
				Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
				if(dateProd.after(date1) && dateProd.before(date2)) {
					if(prod.getMarca().equals(marca)) {
						numProd++;
					}
				}
			}
		}
		return numProd;	
    }
	
	@GET
	@Path("mediaallmes")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public double getMediaAllMesData(@Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		Date d = new Date();
		String anyo = String.valueOf(d.getYear()+1900);
		ArrayList<Integer> arrayNumProd = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			
			for(int mes = 1; mes < 13; mes++) {
				
				String strdate1 = null;
				String strdate2 = null;
				
				if(mes == 1) {
					strdate1 = "31/12/" + String.valueOf(Integer.parseInt(anyo) - 1);;
				}else {
					strdate1 = "31/" + String.valueOf(mes - 1) + "/" + anyo;
				}
				if(mes == 12) {
					strdate2 = "01/01/" + String.valueOf(Integer.parseInt(anyo) + 1);
				}else {
					strdate2 = "01/" + String.valueOf(mes + 1) + "/" + anyo;
				}
				
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
				Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
				
				int numProd = 0;
				
				for(Producto prod : array_productos) {
					Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
					if(dateProd.after(date1) && dateProd.before(date2)) {
						numProd++;
					}
				}
				arrayNumProd.add(numProd);	
			}
		}
		
		int suma = 0;
		for(Integer i: arrayNumProd) suma += i;
		
		return Double.valueOf(suma)/Double.valueOf(arrayNumProd.size());
    }
	
	@GET
	@Path("medianombremes")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public double getMediaNombreMesData(@QueryParam("nombre") String nombre, @Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		Date d = new Date();
		String anyo = String.valueOf(d.getYear()+1900);
		ArrayList<Integer> arrayNumProd = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			
			for(int mes = 1; mes < 13; mes++) {
				
				String strdate1 = null;
				String strdate2 = null;
				
				if(mes == 1) {
					strdate1 = "31/12/" + String.valueOf(Integer.parseInt(anyo) - 1);;
				}else {
					strdate1 = "31/" + String.valueOf(mes - 1) + "/" + anyo;
				}
				if(mes == 12) {
					strdate2 = "01/01/" + String.valueOf(Integer.parseInt(anyo) + 1);
				}else {
					strdate2 = "01/" + String.valueOf(mes + 1) + "/" + anyo;
				}
				
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
				Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
				
				int numProd = 0;
				
				for(Producto prod : array_productos) {
					Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
					if(dateProd.after(date1) && dateProd.before(date2)) {
						if(prod.getNombre().equals(nombre)) {
							numProd++;
						}
					}
				}
				arrayNumProd.add(numProd);	
			}
		}
		
		int suma = 0;
		for(Integer i: arrayNumProd) suma += i;
		
		return Double.valueOf(suma)/Double.valueOf(arrayNumProd.size());
    }
	
	
	@GET
	@Path("mediamarcames")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public double getMediaMarcaMesData(@QueryParam("marca") String marca, @Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		Date d = new Date();
		String anyo = String.valueOf(d.getYear()+1900);
		ArrayList<Integer> arrayNumProd = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			
			for(int mes = 1; mes < 13; mes++) {
				
				String strdate1 = null;
				String strdate2 = null;
				
				if(mes == 1) {
					strdate1 = "31/12/" + String.valueOf(Integer.parseInt(anyo) - 1);;
				}else {
					strdate1 = "31/" + String.valueOf(mes - 1) + "/" + anyo;
				}
				if(mes == 12) {
					strdate2 = "01/01/" + String.valueOf(Integer.parseInt(anyo) + 1);
				}else {
					strdate2 = "01/" + String.valueOf(mes + 1) + "/" + anyo;
				}
				
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
				Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
				
				int numProd = 0;
				
				for(Producto prod : array_productos) {
					Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
					if(dateProd.after(date1) && dateProd.before(date2)) {
						if(prod.getMarca().equals(marca)) {
							numProd++;
						}
					}
				}
				arrayNumProd.add(numProd);	
			}
		}
		
		int suma = 0;
		for(Integer i: arrayNumProd) suma += i;
		
		return Double.valueOf(suma)/Double.valueOf(arrayNumProd.size());
    }
	
	@GET
	@Path("mediaallanyo")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public double getMediaAllAnyoData(@QueryParam("anyobase") String anyobase, @Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		Date d = new Date();
		String anyo = String.valueOf(d.getYear()+1900);
		ArrayList<Integer> arrayNumProd = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			
			for(int anyoMod = Integer.parseInt(anyobase); anyoMod <= Integer.parseInt(anyo); anyoMod++) {
				
				String strdate1 = "31/12/" + String.valueOf(anyoMod - 1);
				String strdate2 = "01/01/" + String.valueOf(anyoMod + 1);
				
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
				Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
				
				int numProd = 0;
				
				for(Producto prod : array_productos) {
					Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
					if(dateProd.after(date1) && dateProd.before(date2)) {
						numProd++;
					}
				}
				arrayNumProd.add(numProd);	
			}
		}
		
		int suma = 0;
		for(Integer i: arrayNumProd) suma += i;
		
		return Double.valueOf(suma)/Double.valueOf(arrayNumProd.size());
    }
	
	@GET
	@Path("medianombreanyo")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public double getMediaNombreAnyoData(@QueryParam("anyobase") String anyobase, @QueryParam("nombre") String nombre, @Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		Date d = new Date();
		String anyo = String.valueOf(d.getYear()+1900);
		ArrayList<Integer> arrayNumProd = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			
			for(int anyoMod = Integer.parseInt(anyobase); anyoMod <= Integer.parseInt(anyo); anyoMod++) {
				
				String strdate1 = "31/12/" + String.valueOf(anyoMod - 1);
				String strdate2 = "01/01/" + String.valueOf(anyoMod + 1);
				
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
				Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
				
				int numProd = 0;
				
				for(Producto prod : array_productos) {
					Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
					if(dateProd.after(date1) && dateProd.before(date2)) {
						if(prod.getNombre().equals(nombre)) {
							numProd++;
						}
					}
				}
				arrayNumProd.add(numProd);	
			}
		}
		
		int suma = 0;
		for(Integer i: arrayNumProd) suma += i;
		
		return Double.valueOf(suma)/Double.valueOf(arrayNumProd.size());
    }
	
	@GET
	@Path("mediamarcaanyo")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public double getMediaMarcaAnyoData(@QueryParam("anyobase") String anyobase, @QueryParam("marca") String marca, @Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		Date d = new Date();
		String anyo = String.valueOf(d.getYear()+1900);
		ArrayList<Integer> arrayNumProd = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			
			for(int anyoMod = Integer.parseInt(anyobase); anyoMod <= Integer.parseInt(anyo); anyoMod++) {
				
				String strdate1 = "31/12/" + String.valueOf(anyoMod - 1);
				String strdate2 = "01/01/" + String.valueOf(anyoMod + 1);
				
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
				Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
				
				int numProd = 0;
				
				for(Producto prod : array_productos) {
					Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
					if(dateProd.after(date1) && dateProd.before(date2)) {
						if(prod.getMarca().equals(marca)) {
							numProd++;
						}
					}
				}
				arrayNumProd.add(numProd);	
			}
		}
		
		int suma = 0;
		for(Integer i: arrayNumProd) suma += i;
		
		return Double.valueOf(suma)/Double.valueOf(arrayNumProd.size());
    }
	
	@GET
	@Path("mesprodnombre")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public int getMesProdNombreData(@QueryParam("nombre") String nombre, @QueryParam("anyo") String anyo, @Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		Date d = new Date();
		ArrayList<Integer> arrayNumProd = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			
			for(int mes = 1; mes < 13; mes++) {
				
				String strdate1 = null;
				String strdate2 = null;
				
				if(mes == 1) {
					strdate1 = "31/12/" + String.valueOf(Integer.parseInt(anyo) - 1);;
				}else {
					strdate1 = "31/" + String.valueOf(mes - 1) + "/" + anyo;
				}
				if(mes == 12) {
					strdate2 = "01/01/" + String.valueOf(Integer.parseInt(anyo) + 1);
				}else {
					strdate2 = "01/" + String.valueOf(mes + 1) + "/" + anyo;
				}
				
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
				Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
				
				int numProd = 0;
				
				for(Producto prod : array_productos) {
					Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
					if(dateProd.after(date1) && dateProd.before(date2)) {
						if(prod.getNombre().equals(nombre)) {
							numProd++;
						}
					}
				}
				arrayNumProd.add(numProd);	
			}
		}
		
		return arrayNumProd.indexOf(Collections.max(arrayNumProd)) + 1;
    }
	
	@GET
	@Path("mesprodmarca")
    @Secured
    @Produces(MediaType.APPLICATION_JSON)
    public int getMesProdMarcaData(@QueryParam("marca") String marca, @QueryParam("anyo") String anyo, @Context SecurityContext securityContext) throws ParseException{
        Principal principal = securityContext.getUserPrincipal();
        String username = principal.getName();
        
        List<Distribuidor> distris = getDistrisDB(username);
		
		ArrayList<Producto> array_productos = new ArrayList<>();
		Date d = new Date();
		ArrayList<Integer> arrayNumProd = new ArrayList<>();
		
		if(!distris.isEmpty()) {
			String codDistri = distris.get(0).getCodigo_distr();
			MyResource mr = new MyResource();
			array_productos = mr.getProductos(codDistri);
			
			for(int mes = 1; mes < 13; mes++) {
				
				String strdate1 = null;
				String strdate2 = null;
				
				if(mes == 1) {
					strdate1 = "31/12/" + String.valueOf(Integer.parseInt(anyo) - 1);;
				}else {
					strdate1 = "31/" + String.valueOf(mes - 1) + "/" + anyo;
				}
				if(mes == 12) {
					strdate2 = "01/01/" + String.valueOf(Integer.parseInt(anyo) + 1);
				}else {
					strdate2 = "01/" + String.valueOf(mes + 1) + "/" + anyo;
				}
				
				Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate1);
				Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(strdate2);
				
				int numProd = 0;
				
				for(Producto prod : array_productos) {
					Date dateProd = new SimpleDateFormat("dd/MM/yyyy").parse(prod.getFechacompr());
					if(dateProd.after(date1) && dateProd.before(date2)) {
						if(prod.getMarca().equals(marca)) {
							numProd++;
						}
					}
				}
				arrayNumProd.add(numProd);	
			}
		}
		
		return arrayNumProd.indexOf(Collections.max(arrayNumProd)) + 1;
    }
	
	

}
