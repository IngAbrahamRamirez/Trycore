export * from './activities.service';
import { ActivitiesService } from './activities.service';
export * from './projectMetrics.service';
import { ProjectMetricsService } from './projectMetrics.service';
export * from './projects.service';
import { ProjectsService } from './projects.service';
export * from './users.service';
import { UsersService } from './users.service';
export const APIS = [ActivitiesService, ProjectMetricsService, ProjectsService, UsersService];
