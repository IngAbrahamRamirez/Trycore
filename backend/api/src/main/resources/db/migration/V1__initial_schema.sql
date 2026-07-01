CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE TYPE project_status AS ENUM
(
    'PLANNED',
    'IN_PROGRESS',
    'COMPLETED',
    'CANCELLED'
);

CREATE TABLE users
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    first_name VARCHAR(100) NOT NULL,

    last_name VARCHAR(100) NOT NULL,

    email VARCHAR(255) NOT NULL,

    password VARCHAR(255) NOT NULL,

    enabled BOOLEAN NOT NULL DEFAULT TRUE,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by UUID,

    updated_by UUID,

    CONSTRAINT uk_users_email UNIQUE(email)
);

CREATE TABLE projects
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    user_id UUID NOT NULL,

    name VARCHAR(200) NOT NULL,

    description TEXT,

    start_date DATE,

    end_date DATE,

    status project_status NOT NULL DEFAULT 'PLANNED',

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by UUID,

    updated_by UUID,

    CONSTRAINT fk_projects_users
        FOREIGN KEY(user_id)
        REFERENCES users(id)
);

CREATE TABLE activities
(
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    project_id UUID NOT NULL,

    name VARCHAR(200) NOT NULL,

    budget_at_completion NUMERIC(14,2) NOT NULL,

    planned_percentage NUMERIC(5,2) NOT NULL,

    actual_percentage NUMERIC(5,2) NOT NULL,

    actual_cost NUMERIC(14,2) NOT NULL,

    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,

    created_by UUID,

    updated_by UUID,

    CONSTRAINT fk_activities_projects
        FOREIGN KEY(project_id)
        REFERENCES projects(id),

    CONSTRAINT chk_activity_budget
        CHECK(budget_at_completion > 0),

    CONSTRAINT chk_activity_planned
        CHECK(planned_percentage BETWEEN 0 AND 100),

    CONSTRAINT chk_activity_actual
        CHECK(actual_percentage BETWEEN 0 AND 100),

    CONSTRAINT chk_activity_cost
        CHECK(actual_cost >= 0)
);

CREATE INDEX idx_users_email
ON users(email);

CREATE INDEX idx_projects_user_id
ON projects(user_id);

CREATE INDEX idx_activities_project_id
ON activities(project_id);

COMMENT ON TABLE users
IS 'Application users';

COMMENT ON TABLE projects
IS 'Projects managed by users';

COMMENT ON TABLE activities
IS 'Project activities used for Earned Value calculations';