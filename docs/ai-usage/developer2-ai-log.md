\# AI Usage Log - Developer 2



\## Phase 1: Audit

\* \*\*Date:\*\* 2026-10-23

\* \*\*Tool Used:\*\* Gemini / ChatGPT

\* \*\*Purpose:\*\* Clarified GRASP pattern concepts (Information Expert, Indirection) and requested feedback on Markdown formatting and English grammar for the audit report.

\* \*\*Impact:\*\* Maintained proper audit structure according to UPC GRASP requirement guidelines without generating direct code or bypassing self-audit rules.### 2.1 Information Expert

\* \*\*Verdict:\*\* Violation

\* \*\*ID:\*\* V-DEV2-01

\* \*\*Module:\*\* Person Module / Taller 1

\* \*\*Evidence:\*\* `PersonServiceImpl.java` line 24 (`findById` method filtering logic)

\* \*\*Explanation:\*\* The service explicitly interrogates person objects to compare IDs rather than encapsulating ID comparison or business rules within the domain class.

\* \*\*Consecuence:\*\* Tight coupling between service filtering and internal state representation.

\* \*\*Proposed Solution:\*\* Delegate identity checks or specific validation directly to domain entities.

\* \*\*Code from other member:\*\* No.



\### 2.2 Creator

\* \*\*Verdict:\*\* Correct

\* \*\*Evidence:\*\* `PersonServiceImpl.java` instantiates `PersonRepositoryImpl` as the service manages person data persistence.

\* \*\*Explanation:\*\* The service directly uses and records person data, adhering to Creator principles.

