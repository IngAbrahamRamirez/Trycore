export interface DataTableColumn {

    field: string;

    header: string;

}

export interface DataTableModel {

    columns: DataTableColumn[];

    data: Record<string, unknown>[];

}
