CREATE TABLE location (
    locationName VARCHAR(100) NOT NULL,
    city VARCHAR(100) NOT NULL,
    region VARCHAR(100) NOT NULL,
    country VARCHAR(100) NOT NULL,
    id UUID NOT NULL PRIMARY KEY
);

CREATE TABLE sports(
    id UUID NOT NULL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    start DATE NOT NULL,
    final DATE NOT NULL,
    cost INT NOT NULL,
    locationId UUID NOT NULL,
    FOREIGN KEY(locationId) REFERENCES location(id) ON DELETE CASCADE
);