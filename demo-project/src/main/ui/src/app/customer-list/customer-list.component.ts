import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})


export class CustomerListComponent implements OnInit {

  private customers: Customer[];

  private newCustomer: Customer;

  constructor() { }

  ngOnInit() { 
    this.customers = customerCollection;
    this.newCustomer = new Customer();
  }

  onSubmit(customerForm: NgForm) {
    if (customerForm.valid) {
      this.customers.push(this.newCustomer);
      this.newCustomer = new Customer();
    }
  }
}
  export class Customer {
    name: String;
    dateBirth: String;
    email: String;
  }

    export const customerCollection = [
     /* {
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
      }*/
    ];


