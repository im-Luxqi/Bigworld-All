import { Component, OnInit } from "@angular/core";
import { NbLoginComponent, NbAuthService, NbAuthJWTToken } from "@nebular/auth";
import { Router } from "@angular/router";
import { tap } from "rxjs/operators";

@Component({
  selector: "ngx-login",
  templateUrl: "./login.component.html"
})
export class LoginComponent extends NbLoginComponent {

  ngOnInit() {
    this.service.onTokenChange().subscribe((token: NbAuthJWTToken) => {
      if (token.isValid()) {
        console.log(token);
        this.router.navigate(["pages/dashboard"]);
      }
    });
  }

}
