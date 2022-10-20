import { Component, Inject, OnInit } from '@angular/core';
import { MAT_DIALOG_DATA } from '@angular/material/dialog';

@Component({
  selector: 'app-error-pop-up',
  templateUrl: './error-pop-up.component.html',
  styleUrls: ['./error-pop-up.component.css']
})
export class ErrorPopUpComponent implements OnInit {

  Msg;
  constructor(@Inject(MAT_DIALOG_DATA) public data) {
    this.Msg = data.Msg;
  }

  ngOnInit(): void {
  }

}
