# AI Usage Log - Developer 2 (Breiner)

## Summary of AI Interaction
This document logs the interaction and support provided by AI tools during the implementation of integration adjustments assigned to Developer 2.

---

### Entry 1: Adjustment A2 - Warranty Circular Dependency Fix
- **Prompt / Query:** Assistance in refactoring SaleService and WarrantyService to remove circular dependency.
- **AI Recommendation:** Replace full object references with entity IDs in the warranty persistence layer.
- **Applied Solution:** Decoupled service constructors and adjusted repo calls to resolve build issues.

---

### Entry 2: Adjustment A4 - Return Accessory Stock Restoration
- **Prompt / Query:** How to restore accessory inventory upon return processing.
- **AI Recommendation:** Extend return handler to invoke AccessoryService.restoreStock.
- **Applied Solution:** Integrated stock increment logic for accessories when registering returns.

---

### Entry 3: Adjustment A6 - Monthly Balance Report Refactor
- **Prompt / Query:** Correcting net monthly balance calculations including discounts and extended warranties.
- **AI Recommendation:** Separate calculation logic into calculateMonthlySales and calculateMonthlyReturns.
- **Applied Solution:** Implemented both methods to ensure accurate net balance calculation.

---

### Entry 4: Adjustment A7 - Return Warranty Cancellation
- **Prompt / Query:** Automating warranty voiding when returning product or console items.
- **AI Recommendation:** Call WarrantyService.cancelWarranties inside ReturnService.registerReturn.
- **Applied Solution:** Connected warranty service to return flow and updated return history queries.
