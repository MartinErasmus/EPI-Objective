import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'currency-list',
  templateUrl: './currency-list.component.html',
  styleUrls: ['./currency-list.component.css']
})
export class CurrencyListComponent implements OnInit {

  constructor() { }

  @Input()
  currency:string;

  ngOnInit(): void {
  }

}
