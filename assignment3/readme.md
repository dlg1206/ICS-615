# Bandit & Trufflehog Sandbox

> Docker sandbox for using Bandit and Trufflehog

## Quickstart

1. Build the image

```bash
docker build -t btsand .
```

> [!WARNING]
> The first build may take several minutes

2. Launch the Sandbox container

```bash
docker run --rm -it -v "<absolute path to project>:/code" btsand
```

This will open a shell into a box with bandit and trufflehog installed. The code will be mounted at `/code` inside the
box