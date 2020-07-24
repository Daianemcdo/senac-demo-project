import { Component } from '@angular/core';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent {

  customers = [
    {
    name: "Aristóteles",
    born: "500 A.C",
    email: "aristoteles@sc.senac.br"
  },

  {
    name: "Platão",
    born: "700 A.C",
    email: "platao@sc.senac.br"
  },
  {
    name: "Tales de Mileto",
    born: "625 A.C",
    email: ""
  }
];

}