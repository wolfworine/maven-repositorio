package com.journaldev.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.journaldev.jpa.data.Atributo;

@Repository
public interface AtributoRepository extends CrudRepository<Atributo, Long>{

	public final static String FIND_BY_PARAMETRO= "SELECT d " + 
            "FROM Atributo a " + 
            "JOIN a.d_detalle d";
	 @Query(FIND_BY_PARAMETRO)
	    public List<Atributo> findParametro();


	 public final static String FIND_BY_PARAMETRO3= "SELECT atri " + 
	            "FROM Atributo atri " +
	            "JOIN atri.a_aplicacion a " +
	            "JOIN atri.b_rol r " +
	            "JOIN atri.c_suministro s " +
	            "JOIN atri.d_detalle d "+
	            "WHERE a.codigo= :aplicacion "+
	            "and s.id = :id_suministro "+
	            "and r.id = :id_rol "+
	            "and d.d_parametro = :parametro ";
	            	 
	@Query(FIND_BY_PARAMETRO3)
	public List<Atributo> findParametro3(@Param("aplicacion") Long aplicacions,@Param("id_rol") Long id_rol,
			@Param("id_suministro") Long id_suministro,@Param("parametro") String parametro);

	 public final static String FIND_BY_PARAMETRO2= "SELECT atri " + 
	            "FROM Atributo atri " +
	            "JOIN atri.b_rol r " +
	            "JOIN atri.c_suministro s " +
	            "JOIN atri.d_detalle d "+
	            "WHERE s.id = :id_suministro "+
	            "and r.id = :id_rol "+
	            "and d.d_parametro = :parametro ";
	
	@Query(FIND_BY_PARAMETRO2)
	public List<Atributo> findParametro2(@Param("id_rol") Long id_rol,@Param("id_suministro")  Long id_suministro,
			@Param("parametro") String parametro);

/*	 public final static String FIND_BY_ATRIBUTO= "SELECT atri " + 
	            "FROM Atributo atri " +
	            "JOIN atri.b_rol r " +
	            "JOIN atri.c_suministro s " +
	            "JOIN atri.d_detalle d "+
	            "WHERE s.id = :id_suministro "+
	            "and r.id = :id_rol "+
	            "and d.d_parametro = :parametro ";
	@Query(FIND_BY_ATRIBUTO)
	public List<Atributo> findAtributo(String id, Long codigo);*/
	
	
	
	 public final static String FIND_BY_APPAREA= "SELECT atri " + 
	            "FROM Atributo atri " +
	            "JOIN atri.a_aplicacion a " +
	            "JOIN atri.b_rol r " +
	            "JOIN r.b_area ar " +
	            "JOIN atri.c_suministro s " +
	            "JOIN atri.d_detalle d "+
	            "JOIN atri.e_estado e "+
	            "WHERE "+
	            "a.codigo = :aplicacion "+
	            "and ar.codigo = :area " +
     			"and e.id = 1 ";
	@Query(FIND_BY_APPAREA)
	public List<Atributo> findAppArea(@Param("aplicacion") Long aplicacion,@Param("area") Long area);
	

/*	SELECT r.descripcion as rol ,c.nombre as cargo,ar.nombre as area,ap.nombre as aplicacion ,r.tipo,d.parametro,d.atributo_nombre
	FROM atributo a
	inner join aplicacion ap on ap.id=a.id_aplicacion
	inner join rol r on a.id_rol=r.id_rol
	inner join area ar on ar.id=r.id_area
	inner join detalle d on d.id_detalle=a.id_detalle
	inner join cargo c on c.id=r.id_cargo
	inner join estado e on e.id_estado=a.id_estado
	where ap.nombre ="Portal" and ar.nombre="ARQUITECTURA EMPRESARIAL" and e.id_estado=1
	order by r.descripcion, d.parametro desc*/
	
/*		public final static String FIND_BY_PARAMETRO= "SELECT d " + 
	            "FROM Atributo a " + 
	            " JOIN a.d_detalle d" +
	            " WHERE a.a_rol.id = :id_rol "+
	            "and a.c_suministro.id = :id_suministro "+
	            "and d.d_parametro = :d_parametro";
	 
    @Query(FIND_BY_PARAMETRO)
    public List<Atributo> findParametro(@Param("id_rol") Long id_rol,
    		@Param("id_suministro") Long id_suministro,
    		@Param("d_parametro") String parametro);*/
    
/*	public final static String FIND_BY_PARAMETRO2= "SELECT s " + 
            "FROM Atributo s " +
            "WHERE s.id_rol = :id_rol "+
            "and s.id_suministro = :id_suministro "+
            "and s.parametro = :parametro "+
            "and s.aplicacion= :aplicacion";
    @Query(FIND_BY_PARAMETRO2)
	public List<Atributo> findParametro2(@Param("id_rol") Long id_rol,@Param("id_suministro") Long id_suministro,@Param("parametro") 
			String parametro,@Param("aplicacion")  String aplicacion);
*/
}
