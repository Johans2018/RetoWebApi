# Technical Design Notes

## 1. Key Design Decisions

### Screenplay Pattern
I selected the Screenplay Pattern because it provides a clear separation of responsibilities, encourages reusable Tasks, Questions and Interactions, and improves maintainability as the test suite grows.

Trade-off:
It requires a steeper learning curve than Page Object Model, but scales significantly better for medium and large automation projects.

---

### Centralized Configuration
Environment-specific configuration is managed through `serenity.conf`, allowing UI and API base URLs to change without modifying test code.

Trade-off:
It introduces an additional configuration layer, but greatly simplifies execution across multiple environments.

---

### Reusable API Client Layer
REST interactions are encapsulated inside dedicated client classes instead of being implemented directly in test steps.

Trade-off:
This adds an abstraction layer but improves readability, reuse, and maintainability.

---

## 2. Flakiness Prevention

The framework avoids unstable tests by:

- Using explicit waits instead of `Thread.sleep()`.
- Keeping selectors centralized.
- Separating test data from test logic.
- Executing independent scenarios.
- Reusing Tasks and Questions instead of duplicating code.
- Isolating API requests inside reusable clients.

---

## 3. Scaling

If the suite grew to 500 tests and several engineers joined the project, I would:

- Split UI and API modules.
- Introduce test factories and builders.
- Improve parallel execution.
- Integrate Docker/Grid for distributed execution.
- Add static analysis (SonarQube) and quality gates.
- Increase CI pipeline optimization with selective execution.

---

## 4. Future Improvements

With two additional weeks I would:

- Integrate Allure alongside Serenity reports.
- Add API contract validation.
- Introduce retry mechanisms only for known infrastructure failures.
- Implement automatic test data generation.
- Add visual regression testing.
- Configure Docker-based execution for local consistency.

# Autor 👨‍💻 
## Jonathan Hans Ballesteros