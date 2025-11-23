import { Component, OnInit } from '@angular/core';
import { CarService } from '../../services/car.service';
import { Car } from '../../models/car.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  featuredCar: Car | null = null;
  categories = [
    { name: 'Sports Cars', icon: '🏎️', count: 0 },
    { name: 'Classic Cars', icon: '🚗', count: 0 },
    { name: 'SUVs', icon: '🚙', count: 0 },
    { name: 'Electric Vehicles', icon: '⚡', count: 0 },
    { name: 'Hypercars', icon: '🔥', count: 0 }
  ];
  loading = true;

  constructor(private carService: CarService) {}

  ngOnInit(): void {
    this.loadFeaturedCar();
  }

  loadFeaturedCar(): void {
    this.carService.getFeaturedCars().subscribe({
      next: (cars) => {
        if (cars && cars.length > 0) {
          this.featuredCar = cars[0];
        }
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }
}

