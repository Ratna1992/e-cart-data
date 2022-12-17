package com.ecart.data.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;

import com.ecart.data.entity.OrderDataEntity;
import com.ecart.data.pojo.ErrorResponse;
import com.ecart.data.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1")
@Api(value = "E-Cart-Data-Controller")
public class OrderDataController {

	@Autowired
	OrderService orderService;

	@GetMapping("/orders/data")
	@ApiImplicitParam(name = "Authorization", required = true, allowEmptyValue = false, paramType = "header", dataTypeClass = String.class, example = "Basic cmF0bmE6cmF0bmE=")
	@ApiOperation(value = "Returns E-Cart Data", response = OrderDataEntity[].class, notes = "It gives duplicate/non relational data json", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiResponses(value = { @ApiResponse(code = 400, response = ErrorResponse.class, message = "bad request"),
			@ApiResponse(code = 401, message = "Unauthorized", response = ErrorResponse.class),
			@ApiResponse(code = 403, message = "Forbidden", response = ErrorResponse.class),
			@ApiResponse(code = 404, message = "Not found", response = ErrorResponse.class),
			@ApiResponse(code = 500, response = ErrorResponse.class, message = "internal server error") })
	public ResponseEntity<?> getOrdersData() {
		List<OrderDataEntity> orders = orderService.getOrders();
		try {
			if (orders.isEmpty()) {
				return new ResponseEntity<>("no data available", HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {

			if (e instanceof HttpStatusCodeException) {
				HttpStatusCodeException httpStatusCodeException = (HttpStatusCodeException) e;
				return new ResponseEntity<>(httpStatusCodeException.getMessage(),
						httpStatusCodeException.getStatusCode());
			}
		}
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

}
