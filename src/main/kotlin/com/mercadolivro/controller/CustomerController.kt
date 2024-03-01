package com.mercadolivro.controller

import com.mercadolivro.model.CustomerModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping

@RestController
@RequestMapping("customer")
class CustomerController {
    @GetMapping
    fun getCostumer(): CustomerModel {
        return CustomerModel("1", "Daniel", "daniel.dxdb@gmail.com")
    }
}