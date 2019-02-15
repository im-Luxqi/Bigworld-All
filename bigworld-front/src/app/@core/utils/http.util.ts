import { Config } from './../../app-config';
import {Injectable} from "@angular/core";
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/catch';
import 'rxjs/add/operator/map';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { NbAuthService } from '@nebular/auth';



@Injectable({
  providedIn: 'root',
})
export class HttpUtil{
  private baseUrl:string;
  private jwtToken:string;
  private pubHeader:any;
  constructor(private config:Config, 
    private http: HttpClient,
    private authService: NbAuthService,
    ){
    let app = config.appConfig;
    this.baseUrl = app.baseUrl;
    this.authService.getToken().subscribe((data) =>{
      if(data!=null) this.jwtToken = data.toString();
    });
    this.pubHeader = [
      {'Authorization': 'Bearer ' + this.jwtToken},
      { 'Content-Type': 'application/json' }
    ]
  }

  post(url:string, param?:any):Observable<any> {
    const httpUrl = this.baseUrl + url;
    const httpOptions = {
      headers: new HttpHeaders(...this.pubHeader),
    }; 
    return this.http.post(httpUrl,{},httpOptions);
  }


}
