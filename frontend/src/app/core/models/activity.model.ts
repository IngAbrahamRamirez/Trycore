export interface Activity {

    id: number;

    projectId: number;

    name: string;

    description: string;

    plannedValue: number;

    earnedValue: number;

    actualCost: number;

    progress: number;

    startDate: string;

    endDate: string;

}