class Matrix {
  int row, col
  def mat

  Matrix(r, c) {
    assert r > 0 && c > 0 : "Incorrect dimensions"
    this.row = r
    this.col = c
    mat = new int[this.row][this.col]
  }

  public void fillMat() {
    for(int i=0; i<row; i++)
      for(int j=0; j<col; j++)
        mat[i][j] = i*2+j*3
  }
}

println("Enter row and column size")
int r = System.in.newReader().readLine() as int
println("row = ${r}")
int c = System.in.newReader().readLine() as int
println("column = ${c}")
def m1 = new Matrix(r, c)

m1.fillMat()

println("Matrix is")
println(m1.mat)
