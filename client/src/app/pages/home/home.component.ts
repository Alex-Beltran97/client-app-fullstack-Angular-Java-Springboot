import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  form: FormGroup;

  constructor(
    private fb: FormBuilder,
    private router: Router
  ) {
    this.form = this.fb.group({
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
    return this.form.get("docType");
  }
  get getDocNumber() {
    return this.form.get("docNumber");
  }

  handleSubmit() {
    if (this.form.valid) {
      const {docType, docNumber} = {
        docType: this.getDocType?.value.trim(),
        docNumber: this.getDocNumber?.value .trim(),
      };
      this.router.navigate([`user-data/${ docType}/${ docNumber }`]);
    }
  }
}
