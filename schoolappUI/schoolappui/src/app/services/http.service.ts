import { Injectable } from '@angular/core';
import 'rxjs/Rx';
import { URLConstants } from '../constants/urlconstants';
import { HttpClient, HttpParams } from '@angular/common/http';
import { CommonService } from './common.service';
import { map } from 'rxjs/operators';
import { throwError } from 'rxjs';

@Injectable()
export class HttpService {
    constructor(private http: HttpClient, private commonService: CommonService) {
    }

    get(url, options?) {
        var result = this.commonService.checkAndUpdateLoginTime();
        if (result == false)
            return;
        return this.http.get(url, options)
        .pipe(map(res => res));
    }

    post(url, data, options?) {
        var result = this.commonService.checkAndUpdateLoginTime();
        if (result == false)
            return;
        return this.http.post(url, data, options)
        .pipe(map(res => res));
    }

    put(url, data, options?) {
        var result = this.commonService.checkAndUpdateLoginTime();
        if (result == false)
            return;
        return this.http.put(url, data, options)
        .pipe(map(res => res));
    }
    delete(url, options?) {
        var result = this.commonService.checkAndUpdateLoginTime();
        if (result == false)
            return;
        return this.http.delete(url, options)
        .pipe(map(res => res));
    }

    private handleError(error: any) {
        return throwError(error);
    }
}
