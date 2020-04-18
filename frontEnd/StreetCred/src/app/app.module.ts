import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule }   from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { EventComponent } from './event/event.component';
import { CategoryPipe } from './pipes/category.pipe';
import { PredictionComponent } from './prediction/prediction.component';
import { PredictedPipe } from './pipes/predicted.pipe';
import { AppServices } from './Services/app-services.service';
import { TabularComponent } from './tabular/tabular.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    HomeComponent,
    EventComponent,
    CategoryPipe,
    PredictionComponent,
    PredictedPipe,
    TabularComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [LoginComponent,AppServices],
  bootstrap: [AppComponent]
})
export class AppModule { }
