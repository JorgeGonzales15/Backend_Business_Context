package com.upc.cargasinestres.CargaSinEstres;


import com.upc.cargasinestres.CargaSinEstres.Business.model.dto.Servicio.request.ServicioRequestDto;
import com.upc.cargasinestres.CargaSinEstres.Business.model.entity.Servicio;
import com.upc.cargasinestres.CargaSinEstres.Business.repository.IServicioRepository;
import com.upc.cargasinestres.CargaSinEstres.Business.service.Impl.ServicioServiceImpl;
import com.upc.cargasinestres.CargaSinEstres.Shared.exception.ValidationException;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class ServicioServiceImplTest {

	@Mock
	private IServicioRepository servicioRepository;

	@InjectMocks
	private ServicioServiceImpl servicioService;

	public ServicioServiceImplTest() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void createServiceWhenServiceNameExists() {
		String existingServiceName = "existingService";
		ServicioRequestDto requestDto = new ServicioRequestDto();
		requestDto.setName(existingServiceName);
		Servicio existingService = new Servicio();
		existingService.setName(existingServiceName);

		when(servicioRepository.findByName(existingServiceName)).thenReturn(existingService);

		assertThrows(ValidationException.class, () -> servicioService.createServicio(requestDto));
	}
}