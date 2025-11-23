import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CarService } from '../../services/car.service';
import { Car } from '../../models/car.model';

@Component({
  selector: 'app-car-detail',
  templateUrl: './car-detail.component.html',
  styleUrls: ['./car-detail.component.scss']
})
export class CarDetailComponent implements OnInit {
  car: Car | null = null;
  loading = true;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private carService: CarService
  ) {}

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.loadCar(parseInt(id, 10));
    }
  }

  loadCar(id: number): void {
    this.loading = true;
    this.carService.getCarById(id).subscribe({
      next: (car) => {
        this.car = car;
        this.loading = false;
      },
      error: () => {
        this.loading = false;
        this.router.navigate(['/explore']);
      }
    });
  }

  goBack(): void {
    this.router.navigate(['/explore']);
  }
}

