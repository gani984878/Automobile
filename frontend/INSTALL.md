# Frontend Installation Notes

## Dependency Installation

Due to peer dependency conflicts between Angular 15 and ng2-charts, you need to install dependencies with the `--legacy-peer-deps` flag:

```bash
npm install --legacy-peer-deps
```

Or use the npm script:
```bash
npm run install-deps
```

## Why?

The `ng2-charts` library has peer dependencies that conflict with Angular 15. Using `--legacy-peer-deps` allows npm to install the packages despite these conflicts. The application will work correctly as the actual runtime dependencies are compatible.

## Alternative: Use --force

You can also use:
```bash
npm install --force
```

But `--legacy-peer-deps` is generally safer as it only ignores peer dependency conflicts, not other dependency issues.

