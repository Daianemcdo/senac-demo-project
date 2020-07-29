import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})


export class CustomerListComponent implements OnInit {

  private customers: Customer[];

  constructor() { }

  ngOnInit() {
    this.customers = [
      {
        name: "Aristóteles",
        dateBirth: "500 A.C",
        email: "aristoteles@sc.senac.br"
      },

      {
        name: "Platão",
        dateBirth: "700 A.C",
        email: "platao@sc.senac.br"
      },
      {
        name: "Tales de Mileto",
        dateBirth: "625 A.C",
        email: "tales@sc.senac.br"
      }
    ];
  }

  onSubmit(customerForm: NgForm, customerName: String, dateBirth: String, email: String) {
    if (customerForm.valid) {
      let newCustomer = new Customer();
      newCustomer.name = customerName;
      newCustomer.dateBirth = dateBirth;
      newCustomer.email = email;
      this.customers.push(newCustomer);
    }
  }
}

export class Customer {
  name: String;
  dateBirth: String;
  email: String;
}