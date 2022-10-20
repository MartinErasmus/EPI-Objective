import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HttpClientModule} from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MaterialModule } from './material/material.module';
import {CountryListComponent} from './country-list/country-list.component';
import { CurrencyListComponent } from './currency-list/currency-list.component'
import { MatDatepickerModule } from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';
import {MatDialogModule} from '@angular/material/dialog';
import { PopUpComponent } from './pop-up/pop-up.component';
import { ErrorPopUpComponent } from './error-pop-up/error-pop-up.component';



@NgModule({
  declarations: [
    AppComponent,
    EmployeeFormComponent,
    CountryListComponent,
    CurrencyListComponent,
    PopUpComponent,
    ErrorPopUpComponent,
  ],

  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MaterialModule,
    MatDatepickerModule,
    MatInputModule,
    MatFormFieldModule,
    MatDialogModule
    
  ],
  exports:[CountryListComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
