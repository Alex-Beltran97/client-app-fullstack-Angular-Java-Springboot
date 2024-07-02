import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  clientForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router
  ) {
    this.clientForm = this.fb.group({
      docType: ["",
        [
          Validators.required,
          Validators.pattern(/^[pcPC]*$/)
        ]
      ],
      docNumber: ["",
        [
          Validators.required,
          Validators.minLength(8),
          Validators.maxLength(11),
          Validators.pattern(/^\d+$/)
        ]
      ],
    });
  }

  get getDocType() {
    return this.clientForm.get("docType");
  }
  get getDocNumber() {
    return this.clientForm.get("docNumber");
  }

  handleSubmit() {
    if (this.clientForm.valid) {
      const {docType, docNumber} = {
        docType: this.getDocType?.value.trim(),
        docNumber: this.getDocNumber?.value .trim(),
      };
      this.router.navigate([`user-data/${ docType}/${ docNumber }`]);
    }
  }
}
