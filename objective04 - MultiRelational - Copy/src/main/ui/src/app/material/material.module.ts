import { NgModule } from '@angular/core';
import {MatIconModule} from '@angular/material/icon';
const MartialComponents=[
  MatIconModule
]


@NgModule({
  imports: [MartialComponents],
  exports:[MartialComponents]

})
export class MaterialModule { }
