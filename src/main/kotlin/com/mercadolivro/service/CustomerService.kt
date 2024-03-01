package com.mercadolivro.service

import com.mercadolivro.controller.request.PostCustomerRequest
import com.mercadolivro.model.CustomerModel
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.*

@Service
class CustomerService {
    val customers = mutableListOf<CustomerModel>()

    fun getAll(name: String?): List<CustomerModel> {
        name?.let {
            return customers.filter { it.name.contains(name, true) }
        }
        return customers
    }

    fun get(id: Int): CustomerModel {
        val customer = customers.first { it.id == id }

        return customer
    }

    fun create(model: PostCustomerRequest): CustomerModel {
        val id = if(customers.isEmpty()) {
            1
        } else {
            customers.last().id + 1
        }

        val customer = CustomerModel(id, model.name, model.email)
        customers.add(customer)

        return customer;
    }

    fun update(id: Int, model: PostCustomerRequest): CustomerModel {
        customers.first { it.id == id }.let {
            it.name = model.name
            it.email = model.email

            return it
        }
    }

    fun delete(id: Int) {
        customers.removeIf { it.id == id }
    }
}