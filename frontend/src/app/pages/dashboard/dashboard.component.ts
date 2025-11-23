import { Component, OnInit } from '@angular/core';
import { CarService } from '../../services/car.service';
import { DashboardStats } from '../../models/car.model';
import { ChartConfiguration, ChartType } from 'chart.js';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {
  stats: DashboardStats | null = null;
  loading = true;

  // Chart data
  horsepowerChartData: ChartConfiguration['data'] | null = null;
  typeChartData: ChartConfiguration['data'] | null = null;
  salesChartData: ChartConfiguration['data'] | null = null;
  performanceRating = 0;

  constructor(private carService: CarService) {}

  ngOnInit(): void {
    this.loadDashboardStats();
  }

  loadDashboardStats(): void {
    this.loading = true;
    this.carService.getDashboardStats().subscribe({
      next: (stats) => {
        this.stats = stats;
        this.processChartData(stats);
        this.loading = false;
      },
      error: () => {
        this.loading = false;
      }
    });
  }

  processChartData(stats: DashboardStats): void {
    // Horsepower Trends (Line Chart)
    const years = Object.keys(stats.horsepowerTrends).map(Number).sort();
    this.horsepowerChartData = {
      labels: years.map(y => y.toString()),
      datasets: [{
        label: 'Average Horsepower',
        data: years.map(y => stats.horsepowerTrends[y]),
        borderColor: '#2563eb',
        backgroundColor: 'rgba(37, 99, 235, 0.1)',
        tension: 0.4,
        fill: true
      }]
    };

    // Type Distribution (Pie Chart)
    const types = Object.keys(stats.typeDistribution);
    this.typeChartData = {
      labels: types,
      datasets: [{
        data: types.map(t => stats.typeDistribution[t]),
        backgroundColor: [
          '#2563eb',
          '#f59e0b',
          '#10b981',
          '#ef4444',
          '#8b5cf6',
          '#ec4899'
        ]
      }]
    };

    // Sales by Year (Bar Chart)
    const salesYears = Object.keys(stats.salesByYear).map(Number).sort();
    this.salesChartData = {
      labels: salesYears.map(y => y.toString()),
      datasets: [{
        label: 'Cars',
        data: salesYears.map(y => stats.salesByYear[y]),
        backgroundColor: '#f59e0b',
        borderRadius: 8
      }]
    };

    // Performance Rating (Gauge)
    this.performanceRating = stats.averagePerformanceRating;
  }

  // Chart options
  lineChartOptions: ChartConfiguration['options'] = {
    responsive: true,
    plugins: {
      legend: {
        display: true
      }
    },
    scales: {
      y: {
        beginAtZero: true
      }
    }
  };

  pieChartOptions: ChartConfiguration['options'] = {
    responsive: true,
    plugins: {
      legend: {
        position: 'right'
      }
    }
  };

  barChartOptions: ChartConfiguration['options'] = {
    responsive: true,
    plugins: {
      legend: {
        display: false
      }
    },
    scales: {
      y: {
        beginAtZero: true
      }
    }
  };
}

