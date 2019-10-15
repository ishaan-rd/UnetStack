class Matrix {
  int row, col
  def mat

  Matrix(r, c) {
    assert r > 0 && c > 0 : "Incorrect dimensions"
    this.row = r
    this.col = c
    mat = new int[this.row][this.col]
  }

  public void fillMat(int x, int y) {
    for(int i=0; i<row; i++)
      for(int j=0; j<col; j++)
        mat[i][j] = i*x+j*y
  }

  public void display() {
    println("-----\nMatrix is:")
    println(this.mat)
    println("-----")
  }

  Matrix plus(Matrix other) {
    assert row == other.row : "Incorrect rows"
    assert col == other.col : "Incorrect columns"

    def m = new Matrix(row, col)

    for(int i=0; i<row; i++)
      for(int j=0; j<col; j++)
        m.mat[i][j] = this.mat[i][j] + other.mat[i][j]

    return m
  }

  Matrix multiply(Matrix other) {
    assert col == other.row : "Incorrect dimensions"

    def m = new Matrix(row, other.col)

    for(int i=0; i<row; i++)
      for(int j=0; j<other.col; j++)
        for(int k=0; k<col; k++)
          m.mat[i][j] += this.mat[i][k] * other.mat[k][j]

    return m
  }
}

// ----------------------------
// matrix 1
println("Enter row and column size for matrix 1")
int r = System.in.newReader().readLine() as int
println("row = ${r}")
int c = System.in.newReader().readLine() as int
println("column = ${c}")
def m1 = new Matrix(r, c)

m1.fillMat(2, 3)
m1.display()

// ----------------------------
// matrix 2
println("Enter row and column size for matrix 2")
r = System.in.newReader().readLine() as int
println("row = ${r}")
c = System.in.newReader().readLine() as int
println("column = ${c}")
def m2 = new Matrix(r, c)

m2.fillMat(4, 5)
m2.display()

// addition
def m3 = m1 + m2
println("\nResult of adding two matrices:")
m3.display()

// multiplication
def m4 = m1 * m2
println("\nResult of multiplying two matrices:")
m4.display()

